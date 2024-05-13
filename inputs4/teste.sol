
int sqr( int x )
begin
   begin
    return x*x;
   end
end

int sqrsum( int a, int b )
begin
    int s;
    s = sqr(a + b);
    return s;
end

void main()
begin
    print sqrsum(3,2);
end
/*
void main() begin
    int a = 1;
    int b;
    begin
        int c = 2;
        begin
            int d = 3;
            int e;
            begin
                int f = 4;
            end
            e = 5;
        end
    end
    b = 6;
    begin
        int g = 7;
    end
end
*/