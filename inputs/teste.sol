void main()
begin
    int a = 3;
    int b = 4;
    print sum(a, b);
    print a + " " + b;
end

int sum(int x, int y)
begin
    x = y;
    y = 10;
    return x + y;
end