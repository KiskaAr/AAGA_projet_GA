#include <stdio.h>
#include <stdlib.h>
#include <math.h>


long rand48(long x){
	long result = ((((long)(25214903917*x) +11)) % ((long)pow(2,48)));
	return result;
}


long gen_java_inverse(long v1, long v2){
	long w1 = v1 << 16;
	while(v2 != (rand48(w1) >> 16)){
		w1++;
	}
	
	long w0 =0;
	while(((v1 != (rand48(w0) >> 16)) && (v1 != (rand48(-w0) >> 16))) && (w0 < pow(2, 48))){
		w0=w0+1;
	}
	
	if(v1 == (rand48(w0) >> 16)){
		return (w0 >> 16);
	}
	
	if(v1 == (rand48(-w0) >> 16)){
		return ((-w0) >> 16);
	}
	
	return 0;
}

int main(){ 

	long res1 = rand48(0);
	long res2 = rand48(res1);
	long res3 = rand48(res2);
	
	printf("\nV0 = %ld",res1);
	printf("\nV1 = %ld",res2);
	printf("\nV2 = %ld",res3);
	
	printf("\nResultat : v0 = %ld",gen_java_inverse(res2 >> 16,res3 >> 16));
	
	return 0;
}
