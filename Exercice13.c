#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define BIT 1 
#define OCTET 8*BIT
#define KO OCTET*1024
#define MO KO*1024 
#define P1 1.0

unsigned char binaire(int tab[]) {
  
  unsigned char sum = 0;
  int coeff_pow = 7;
  
  for (int i=0; i<OCTET; i++, coeff_pow--) {
    sum += (tab[i] << coeff_pow);
  }
  
  return sum;
}

int main() {
  
  //Initialiser le générateur
  srand(time(NULL));
	
  FILE* file = fopen("compression_1_0.data", "wb");
  
  if (!file) {
    exit(1);
  }
  
  unsigned char buf[1];
  int bits[OCTET];
  int i=0;
  
  while (i<MO) {
    
    for (int j=0; j<OCTET; j++) {
      if (((double)rand() / (double)RAND_MAX) < P1) {
        bits[j] = 1;
      } else {
        bits[j] = 0;
      }
    }
    
    buf[0] = binaire(bits);
    
    fwrite(buf, sizeof(unsigned char), 1, file);

    i += OCTET;
  }
  
	fclose(file);  
	
	return 0;
}
