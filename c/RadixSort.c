#include<malloc.h>
#include<math.h>
#include<stdlib.h>
#include "List.h"

struct Collection{ 
	int *Elements;
	int LastPos;
}; 
typedef struct Collection *Bucket;

void initializeBucket(Bucket bucket[]){
	int i = 0;
	while(i < 10){
		bucket[i] = (Bucket)malloc(sizeof(Bucket));
		if(bucket[i] == NULL){
			printf("!!!!! OUT OF MEMORY !!!!!");
			exit(0);
		}
		bucket[i]->Elements = malloc(sizeof(int) * 10);
		bucket[i]->LastPos = 0;
		i++;
	}
}

void addToBucket(int i, Bucket B){
	B->Elements[B->LastPos] = i;
	B->LastPos++;
}

int power(int base, int exp){
	int result = 1;
	int i = 0;
	while(i < exp){
		result *= base;
		i++;
	}
	return result; 
}

int findElementAtRadix(int i, int radix){
	int divisor = power(10, radix);
	i /= divisor;
	return i % 10; 
} 

void displayArray(int intArray[], int count){
	int i = 0;
	while(i < count){
		printf("%d->", intArray[i]);
		i++;
	}
	printf("\n");
} 

void displayBuckets(Bucket Buckets[]){
	int i = 0;
	while(i < 10){
		displayArray(Buckets[i]->Elements, Buckets[i]->LastPos);
		i++;
	}
}

void copyBucketsToArray(Bucket bucket[], int intArray[]){
	int Counter = 0, i = 0; 
	while(i < 10){
		int j = 0;
		while(j < bucket[i]->LastPos){
			intArray[Counter] = bucket[i]->Elements[j];
			j++;
			Counter++;
		} 
		bucket[i]->LastPos = 0; 
		i++;
	}	
}

int main(){

	Bucket bucket[10];
	initializeBucket(bucket);
	int intArray[] = {20, 9, 10, 1, 209, 307, 7, 5, 301, 44};
	int radixMax = 3, i = 0;
	displayArray(intArray, 10);
//	displayBuckets(bucket);
	while(i < radixMax){
		int j = 0;
		while(j < 10){
			int bucketNumber = findElementAtRadix(intArray[j], i);
			addToBucket(intArray[j], bucket[bucketNumber]);
			j++;
		}
//		displayBuckets(bucket);
		copyBucketsToArray(bucket, intArray);
		displayArray(intArray, 10);
		i++;
	}
}
