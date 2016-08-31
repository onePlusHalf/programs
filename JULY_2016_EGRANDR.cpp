//faLcon a.k.a rkkaushik012

//EGRANDR - July Challenge 2016

#include <bits/stdc++.h>
using namespace std;
int main()
{
    int t;
    int n,i,temp;
    cin>>t;
    while(t--)
    {
        int arr[6] = {0};
        cin>>n;
        
        for(i = 0;i<n;i++)
        {
            cin>>temp;
            arr[temp]++;
        }
        
        if(arr[1]!=0 || arr[2]!=0 || arr[5]==0 )
            cout<<"No"<<endl;
        else
        {
            int sum = arr[3]*3+arr[4]*4+arr[5]*5;
            if(sum/n < 4)
                cout<<"No"<<endl;
            else
                cout<<"Yes"<<endl;
        }
    }
    return 0;
}