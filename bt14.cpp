#include <iostream>
#include <math.h>
#define MAX_SIZE 100 
 using namespace std; 
void NhapMang(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout<<"Nhap ";
        cin>>arr[i];
    }
}
 
void XuatMang(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout<<arr[i];
    }
}
bool IsPrime(int n)
{
    if (n < 2)
        return false;
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (n % i == 0)
        {
            return false;
        }
    }
    return true;
}
int PrimeCount(int a[], int n)
{
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        if (IsPrime(a[i]))
        {
            count++;
        }
    }
    return count;
}

 
void PrintPrime(int a[], int n)
{
int	dem=0; 
    for (int i = 0; i < n; i++)
    {
        if (IsPrime(a[i]))
        {
            dem++;
        }
        
    }
    cout<<dem; 
}
int main()
{
    int arr[MAX_SIZE];
 
    int n;
    do
    {
        cout<<"Nhap n = ";
        cin>>n; 
    } while (n <= 0 || n > MAX_SIZE);
 

    NhapMang(arr, n);
 

    XuatMang(arr, n);
 

    int primeCount = PrimeCount(arr, n);
    cout<<"\nSo luong so nguyen to la "<< primeCount;
    if(primeCount > 0){
        cout<<"\nDanh sach so nguyen to: ";
        PrintPrime(arr, n);
    }
}
 
