struct TreeNode;

typedef struct TreeNode *Position;
typedef struct TreeNode *SearchTree;

SearchTree MakeEmpty(SearchTree T); 
void DisplayTree(SearchTree T);
SearchTree insert(SearchTree T, int value);
SearchTree delete(SearchTree T, int value);
Position find(SearchTree T, int value);
Position findMax(SearchTree T);
Position findMin(SearchTree T);
void DisplayPosition(Position P);
