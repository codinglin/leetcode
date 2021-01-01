#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    struct ListNode *L, *r,*temp;
    L=(struct ListNode*)malloc(sizeof(struct ListNode));
    temp=L;
    int count=0,sum;
    while(l1!=NULL||l2!=NULL||count>0){
        int a=l1==NULL?0:l1->val;
        int b=l2==NULL?0:l2->val;
        sum=(a+b+count);
        count=sum/10;
        sum=sum%10;
        r=(struct ListNode*)malloc(sizeof(struct ListNode));
        r->val=sum;
        temp->next=r;
        temp=r;
        l1=l1!=NULL?l1->next:NULL;
        l2=l2!=NULL?l2->next:NULL;
    }
    temp->next=NULL;
    return L->next;
}

int main(){
    return 0;
}