#include<bits/stdc++.h>
using namespace std;
#define int long long int
#define mod 1000000007
#define inf 1e18
#define IOS  ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

int32_t main(){
	IOS;
	int t=1;
	cin>>t;
	while(t--){
		int n;cin>>n;
		vector<int>a(n),b(n,0);
		for (int i = 0; i < n; i++)
		{
			cin>>a[i];
		}
		int ans=0;
		for (int i = 1; i < n; i++)
		{
			if(a[i]<a[i-1]&&b[i-1]>25){
				b[i]=b[i-1]+1;
				ans++;
				continue;
			}
			int x=b[i-1]+1,cnt=0;
			while(a[i]+cnt<a[i-1]){
				cnt+=(pow(2ll,x-1));
				ans=max(ans,x);
				x++;
			}
			b[i]=x-1;
		}
		cout<<ans<<"\n";
	}
	return 0;
}