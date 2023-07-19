bool sol(vector<int>&a){
	int av=0;
	int n=a.size();
	for (int i = 0; i < n; i++)
	{
		av+=a[i];
	}
	int ans=0;
	ans+=(av/n);
	av%=n;
	ans+=(((float)av/n)>=0.5?1:0);
	for (int i = 0; i < n; i++)
	{
		if(a[i]==ans)return 1;
	}
	return 0;
}