#include <stdio.h>
#include <stdlib.h>

struct node
{
	int data;
	struct node *next;
};

//insert at begning of link list
void insertbeg(struct node **head, int d)
{
	struct node *n = (struct node*)malloc(sizeof(struct node));
	n->data = d;
	n->next = *head;
	*head = n;
}

//insert at end of link list
void insertend(struct node **head, int d)
{
	struct node *n = (struct node*)malloc(sizeof(struct node));
	n->data = d;
	n->next = NULL;
	if(*head == NULL)
	{
		*head = n;
	}
	else
	{
		struct node *curr = *head;
		while(curr->next)
		{
			curr = curr->next;
		}
		curr->next = n;
	}
}


int main()
{
	struct node *head = NULL; //pointer pointing to linklist
	int size = 0;
	int num = 0;

	printf("Enter no. of elements");
	scanf("%d", &size);

	for(int i = 0; i < size; i++)
	{
		scanf("%d", &num);
		if(i%2 == 0)
		{
			insertbeg(&head, num);
		}
		else
		{
			insertend(&head, num);
		}
	}

	struct node *curr = head;

	//print linklist
	while(1)
	{
		printf("%d", curr->data);
		if(curr->next == NULL)
		{
			break;
		}
		curr = curr->next; //traverse
	}

	return 0;
}
