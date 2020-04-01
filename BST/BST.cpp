// creation, insertion, search in binary searh tree


#include <iostream>

using namespace std;

struct BST {
    int val;
    struct BST *left, *right;

    BST(int data) {
        val = data;
        left = right = NULL;
    }
};
 

// insert in BST
BST* insert(BST *root, int data) {
    if(root == NULL) {
        return new BST(data);
    }

    if(root->val == data) {
        cout<<"No. alreaty exits"<<endl;
    }
    else if(root->val > data) {
        root->left = insert(root->left, data);
    }
    else if(root->val < data) {
        root->right = insert(root->right, data);
    }

    return root;
}

// search BST
void search(BST *root, int num) {
    if(root == NULL) {
        cout<<"Element not found"<<endl;
        return;
    }

    if(root->val == num) {
        cout<<"Element found"<<endl;
        return;
    }
    else if(root->val > num) {
        search(root->left, num);
    }
    else {
        search(root->right, num);
    }
}

// get minimum value from right subtree
BST* minRightValue(BST *root) {
    BST *curr = root;

    while(curr && curr->left) {
        curr = curr->left;
    }
    return curr;
}

BST* deleten(BST *root, int num) {
    if(root == NULL) {
        return root;
    }

    // root->val is smaller than num to deleted 
    // than search right sub tree
    if(root->val < num) {
        root->right = deleten(root->right, num);
    } 
    // root->val is larger than num to be deleted
    // than search left sub tree
    else if(root->val > num) {
        root->left = deleten(root->left, num);
    }

    else {
        // if left subtree is empty than return right subtree
        if(root->left == NULL) {
            return root->right;
        }
        // if right subtree is empty than return left subtree
        else if(root->right == NULL) {
            return root->left;
        }
        else {
            // get min value from right sub tree
            // copy that value in root
            // than delete that val
            BST *temp = minRightValue(root->right);

            root->val = temp->val;
            
            root->right = deleten(root->right, temp->val);
        }
    }


    return root;
}

void inorder(BST *root) {
    if(root == NULL) {
        return;
    }

    inorder(root->left);
    cout<<root->val<<" ";
    inorder(root->right);
}

int main() {
    BST *root = NULL; // root of BST
    int count = 0;
    
    cout << "Enter Number of elements in BST "<<endl;
    cin >> count;
    for(int i = 0; i < count; i++) {
        cout<<"Enter the number to insert";
        int num;
        cin >> num;
        root = insert(root, num);
    }

    inorder(root);

    cout<<"Enter Number of elment to find"<<endl;
    cin >> count;
    for(int i = 0; i < count; i++) {
        cout<<"Enter the number to search";
        int num;
        cin >> num;
        search(root, num);
    }

    cout<<"Enter Number of element to be deleted";
    cin >> count;
    for(int i = 0; i < count; i++) {
        cout<<"Enter the element to be deletd";
        int num;
        cin >> num;
        root = deleten(root, num);
    }

    cout<<"Print BST in order"<<endl;
    inorder(root);
    return 0;
}
