#ifndef _List_H

struct Node;
typedef struct Node *PtrToNode;
typedef PtrToNode List;
typedef PtrToNode Position;

List MakeEmpty(List L);
int isEmpty(List L);
int isLast(List L);
Position find(int Element, List L);
void delete(int Element, List L);
Position findPrevious(int Element, List L);
void insert(int Element, List L, Position P);

#endif	/* _List_H */
