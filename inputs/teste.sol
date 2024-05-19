int test2( int x )
begin
    int i;
    for i = 0 to 10 do
    begin
      x = x * 2;
    end
    return x;
end

string test1( int a, int b )
begin
    return "a = " + a + " b = " + b;
end

void main()
begin
    print test1(test2(1), test2(2));
end