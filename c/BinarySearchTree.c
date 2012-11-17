#include<malloc.h>
#include<stdio.h>
#include<stdlib.h>
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
	printf("%d	\n",P->element);
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

Position findMin(SearchTree T){
	if(T == NULL)
		return NULL;
	else if(T->left == NULL)
		return T;
	else
		return findMin(T->left);
}

Position findMax(SearchTree T){
	if(T != NULL){
		while(T->right != NULL){
			T = T->right;
		}
	}
	return T;
}

SearchTree insert(SearchTree T, int value){
	if(T == NULL){
		T = (SearchTree)malloc(sizeof(SearchTree));
		if(T == NULL){
			printf("Program out of space !!!");
			exit(0);
		}
		else{
			T->element = value;
			T->right = T->left = NULL;
		}
	}
	else if(value < T->element)
		T->left = insert(T->left, value);
	else if(value > T->element)
		T->right = insert(T->right, value);
	return T;
} 

SearchTree delete(SearchTree T, int value){
	Position tempCell;
	if(T == NULL)
		printf("Element not found");
	else if(value < T->element)
		T->left = delete(T->left, value);
	else if(value > T->element)
		T->right = delete(T->right, value);
	else if(T->left && T->right){
		tempCell = findMin(T->right);
		T->element = tempCell->element;
		T->right = delete(T->right, T->element);
	}
	else{
		tempCell = T;
		if(T->left == NULL)
			T = T->right;
		else if(T->right == NULL)
			T = T->left;
		free(tempCell);
	}
	return T;
}

int main(){
	SearchTree T = insert(NULL, 1);
	T = insert(T, 3);
	T = insert(T, 5);
	T = insert(T, 4);
	T = insert(T, 6);
	T = insert(T, 2);
	DisplayTree(T);
	printf("\nDeleting Element 5:");
	T = delete(T, 5);
	DisplayTree(T);
	Position pos = find(T, 2);
	printf("\nFinding Element 2:");
	DisplayPosition(pos);
	Position min = findMin(T);
	printf("The Minimum Element is:");
	DisplayPosition(min);
	Position max = findMax(T);
	printf("The Maximum Element is:");
	DisplayPosition(max);
	T = MakeEmpty(T);
	DisplayTree(T);
}
