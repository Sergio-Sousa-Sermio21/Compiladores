int doubler(int x)
begin
int i = 0
   for i = 0x < 2*x do
   begin
        if x < 0 then
            x = x - 1;
            return x;
        else
        begin
            x = x + 1;
        end
   end
end

void main()
begin
     print doubler(2);
end

