
int sqr( int x )
begin
   if(true) then
   begin
    return x*x;
   end
   return x;
end

int sqrsum( int a, int b )
begin
    int s;
    s = sqr(a + b, b);
    return s;
end

void main()
begin
    print sqrsum(3,2,1);
    print sqrsum(3,"ualg");
end
