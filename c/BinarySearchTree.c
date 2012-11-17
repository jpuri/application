#include<malloc.h>
#include<stdio.h>
#include "BinarySearchTree.h"

struct TreeNode{
	int element;
	SearchTree left;
	SearchTree right;
};

SearchTree MakeEmpty(SearchTree T){
	if(T != NULL){
		MakeEmpty(T->left);
		MakeEmpty(T->right);
		free(T);
	}
	return NULL;
}

void DisplayTree(SearchTree T){
	if(T != NULL){
		printf("%d	",T->element);
		DisplayTree(T->left);
		DisplayTree(T->right);
	}
}

void DisplayPosition(Position P){
	printf("%d	",P->element);
}

Position find(SearchTree T, int value){
	if(T == NULL)
		return NULL;
	else if(value < T->element)
		return find(T->left, value);
	else if(value > T->element)
		return find(T->right, value);
	return T;
}

int main(){
	SearchTree T = (SearchTree)malloc(sizeof(SearchTree));
	T->element = 2;
	T->left = (SearchTree)malloc(sizeof(SearchTree));
	T->left->element = 1;	
	T->right = (SearchTree)malloc(sizeof(SearchTree));
	T->right->element = 3;	
	DisplayTree(T);
	Position pos = find(T, 2);
	DisplayPosition(pos);
	T = MakeEmpty(T);
	DisplayTree(T);
}	
