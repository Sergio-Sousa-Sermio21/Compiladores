int sqr( int x )
begin
   if(true) then
   begin
    return x*x;
   end
end

int sqrsum( int a, int b )
begin
    int s;
    s = sqr(a + b);
end

void main(int x)
begin
    print sqrsum(3,2);
    return x;
end