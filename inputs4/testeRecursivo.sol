void main()
begin
print fact(10);
end

int fact( int n )
begin
if n == 0 then return 1;
return n * fact(n-1);
end