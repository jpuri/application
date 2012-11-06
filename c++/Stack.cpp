#include<iostream>

class Stack{
	private:
  		int Elements[10];
  		int tos;
 	public:
  		Stack();
		bool is_full();
		bool is_empty();
		void display();
		void push(int Element);
		int pop();
};

Stack::Stack(){
	tos = 0;
};

bool Stack::is_full(){
	if(tos == 10)

		return true;
	else
		return false;
}

bool Stack::is_empty(){
	if(tos == 0)
		return true;
	else
		return false;
}

void Stack::push(int Element){
	if(!is_full()){
		Elements[tos] = Element;
		tos++;
	}
}

int Stack::pop(){
	if(!is_empty()){
		return Elements[--tos];
	}
	return 0;
}

void Stack::display(){
	for(int i = tos - 1; i >= 0;i--){
		std::cout << Elements[i];
		std::cout << "->";
	} 
	std::cout << "\n";
}

int main(){
	std::cout << "CREATED NEW STACK\n";
	Stack *stack = new Stack();
	std::cout << "PUSHING INTO STACK\n";
	stack->push(1);
	stack->push(2);
	stack->push(3);
	stack->push(4);
	std::cout << "DISPLAYING STACK";
	stack->display();
	std::cout << "POPING FROM STACK";
	std::cout << "POPED FROM STACK" << std::endl;
	std::cout << stack->pop();
	return 0;
};
