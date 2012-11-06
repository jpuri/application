#include<malloc.h>
#include<stdio.h>
#include<stdlib.h>
#include "List.h"

struct Node{
	int Element;
	Position Next;
};

List MakeEmpty(List L){
	L->Next = NULL;
	return L;
};

int isEmpty(List L){
	return L == NULL;
};

int isLast(Position P){
	return P->Next == NULL;
};

Position find(int Element, List L){
	Position P = L;
	while(P != NULL && P->Element != Element){
		P = P->Next;
	}
	return P;
}

void delete(int Element, List L){
	Position P = find(Element, L);
	Position Prev = findPrevious(Element, L);
	 
	if(isLast(P)){
		Prev->Next = NULL;
	} else{
		Prev->Next = P->Next;
	}
	free(P);
}

Position findPrevious(int Element, List L){
	Position P = L;
	Position Prev = NULL;
	while(P != NULL && P->Element != Element){
		Prev = P;
		P = P->Next;
	}
	return Prev;
}

void insert(int Element, List L, Position P){
	Position New = (PtrToNode)malloc(sizeof(PtrToNode));
	New->Element = Element;
	New->Next = P->Next;
	P->Next = New; 
}

void display(List L){
	Position P = L;
	while(P != NULL){
		printf("%d->",P->Element);
		P = P->Next;
	}
	printf("\n");
}

int main(){

	List emptyList = NULL;
	printf("1 if the list is empty : %d\n", isEmpty(emptyList));

	List L = (PtrToNode)malloc(sizeof(PtrToNode));
	L->Element = 1;
	Position P2 = (PtrToNode)malloc(sizeof(PtrToNode));
	P2->Element = 2;
	L->Next = P2;
	Position P3 = (PtrToNode)malloc(sizeof(PtrToNode));
	P3->Element = 3;
	P2->Next = P3;

	printf("1 if the element is last : %d\n", isLast(P3));
	
	Position P = find(3, L);
	printf("The element if its there in the list: %d\n", P->Element); 

	Position P4 = findPrevious(3, L);
	printf("The previous of 3 is %d\n", P4->Element);

	printf("The list before deletion:");
	display(L);
	delete(2, L);
	printf("The list after deletion:");
	display(L);

	insert(4, L, P3);
	display(L);
} 
