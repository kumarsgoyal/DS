// C program for linked list implementation of stack 
#include <limits.h> 
#include <stdio.h> 
#include <stdlib.h> 

// A structure to represent a stack 
typedef struct StackNode stack;
struct StackNode { 
	int data; 
	stack* next; 
}; 

struct stack* newNode(int data) 
{ 
	stack* stackNode = (stack*)malloc(sizeof(stack)); 
	stackNode->data = data; 
	stackNode->next = NULL; 
	return stackNode; 
} 

int isEmpty(stack* root) 
{ 
	return !root; 
} 

void push(stack** root, int data) 
{ 
	stack* stackNode = newNode(data); 
	stackNode->next = *root; 
	*root = stackNode; 
	printf("%d pushed to stack\n", data); 
} 

int pop(stack** root) 
{ 
	if (isEmpty(*root)) 
	{
		return INT_MIN; 
	}
	else
	{
	    stack* temp = *root; 
    	*root = (*root)->next; 
	    int popped = temp->data; 
	    free(temp); 
	    return popped; 
	}
} 

int peek(stack* root) 
{ 
	if (isEmpty(root)) 
	{
		return INT_MIN; 
	}
	else
	{   
	    return root->data; 
	}
} 

int main() 
{ 
	stack* root = NULL; 

	push(&root, 10); 
	push(&root, 20); 
	push(&root, 30); 

	printf("%d popped from stack\n", pop(&root)); 

	printf("Top element is %d\n", peek(root)); 

	return 0; 
} 
