// { Driver Code Starts
#include <iostream>
using namespace std;

/*Struct of linked list*/
struct Node
{
	int data;
	struct Node *next;
	Node(int x)
	{ //the constructor
		data = x;
		next = NULL;
	}
};

void printList(Node *head)
{ //function to print list
	Node *node = head;
	while (node != NULL)
	{
		cout << node->data << ' ';
		node = node->next;
	}
	cout << endl;
}

Node *insertAtBegining(Node *head, int newData);
Node *insertAtEnd(Node *head, int newData);

int main()
{
	int test;
	cin >> test; //number of testcases input
	while (test--)
	{ //while we have testcases we run the loop
		int n, ch, tmp;
		Node *head = NULL; //initially head is null as linked list is empty
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			cin >> tmp >> ch;
			if (ch)
				head = insertAtEnd(head, tmp);
			else
				head = insertAtBegining(head, tmp);
		}
		printList(head);
	}
	return 0;
}

// } Driver Code Ends
/*Structure of the linked list node is as
struct Node {
  int data;
  struct Node * next;
  Node(int x) {
    data = x;
    next = NULL;
  }
}; */

// function inserts the data in front of the list
Node *insertAtBegining(Node *head, int newData)
{
	Node *newNode = new Node(newData);
	newNode->next = head;

	return newNode;
}

// function appends the data at the end of the list
Node *insertAtEnd(Node *head, int newData)
{

	Node *curr = head;
	Node *newNode = new Node(newData);

	if (curr == NULL)
	{
		return newNode;
	}

	while (curr && curr->next)
	{
		curr = curr->next;
	}

	curr->next = newNode;

	return head;
}
