#include <iostream>
using namespace std;
class base1
{
    public:
    base1()
    {
        cout<<"In base1 Constructor\n";
    }
   ~base1()
    {
        cout<<"In base 1 Destructor\n";
    }
    
};

class base2
{
    public:
    base2()
    {
        
        cout<<"In base2  Constructor\n";
    }
   ~base2()
    {
        cout<<"In base 2 Destructor\n";
    }
    
    
};

class d:public base2,public base1
{
    public:
    const int num;
    d()//:num(10)
    {
        num = 20;
        
        cout<<"In D2 Constructor\n";
    }
    ~d()
    {
        cout<<"In d2 Destructor\n";
    }
    
    
};
int main() {
	//code
//	d2 obj1;
	base2 *obj = new d();
	delete(obj);
	return 0;
}