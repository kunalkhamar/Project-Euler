/********************************************************* 
 * Provides functions for big integer operations
 * string integer (sint): integer represented as a string
**********************************************************/

#include <assert.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>

#define MAX_DIGITS 52

// represent an integer as a series of ASCII digits '0'-'9'
struct sint {
   char digits[MAX_DIGITS + 1];
};

// strim(a) removes leading zeros in a->digits
// assume that a is positive,
//   i.e., the numeric value of a->digits >= 0
// requires: a != NULL
void strim(struct sint *a);

// sadd(a, b) numerically adds a->digits with b->digits and 
// returns the resulting sint. Assume that no overflow will occur
// assume that a and b are positive,
//   i.e., the numeric value of a->digits >= 0 and b->digits >= 0
// requires: a!= NULL and b!= NULL
struct sint sadd(const struct sint *a, const struct sint *b);


////////////////////////// Implementation ////////////////////////////


void strim(struct sint *a) {
  int len = strlen(a->digits);
  for (int i = 0; i < len; i++)
    assert(a->digits[i] >= '0' && a->digits[i] <= '9');
  
  int shift = 0;
  while (shift < len && a->digits[shift] == '0')
    shift++;
  if (shift == len) // if string is "00...000"
    shift--;
  
  for (int i = shift; i < len; i++)
    a->digits[i - shift] = a->digits[i];
  
  a->digits[len - shift] = '\0';
}


struct sint sadd(const struct sint *a, const struct sint *b) {
  struct sint r, acp = *a, bcp = *b;
  strim(&acp);
  strim(&bcp);
  for (int i = 0; i < MAX_DIGITS; i++)
    r.digits[i] = '0';
  r.digits[MAX_DIGITS] = '\0';
  
  int lena = strlen(acp.digits);
  int lenb = strlen(bcp.digits);
  int carry = 0;
  for (int i = 0; i < MAX_DIGITS; ++i) {
    int cur = 0;
    if (i < lena)
      cur += acp.digits[lena - 1 - i] - '0';
    if (i < lenb)
      cur += bcp.digits[lenb - 1 - i] - '0';
    cur += carry;
    carry = cur / 10;
    cur %= 10;
    r.digits[MAX_DIGITS - 1 - i] = '0' + cur;
  }
  
  strim(&r);
  return r;
}


int main(void) {
  struct sint sum = { "0" };
  FILE *fptr;
  fptr = fopen("p013.txt", "r");

  for (int i = 0; i < 100; i++) {
    struct sint in;
    fscanf(fptr, "%s", in.digits);
    sum = sadd(&sum, &in);
  }

  sum.digits[10] = '\0';
  printf("%s\n", sum.digits);
}
