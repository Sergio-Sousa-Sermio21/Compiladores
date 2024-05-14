// Declaração de variáveis e atribuição de valores
int a = 10;
int x;
bool result1;
bool result2;
bool result3;
real b = 3.14;
bool c = true;
string d = "Hello, world!";
int i = 0;

// Função para imprimir variáveis e literais
void printVariables() begin
    print(a); // Deve imprimir: 10
    print(b); // Deve imprimir: 3.14
    print(c); // Deve imprimir: true
    print(d); // Deve imprimir: Hello, world!
    a = Integ(a);
    b = Doub(b);
end

// Função para expressões aritméticas
int Integ(int a) begin
    x = a + 5;
    print(x); // Deve imprimir: 15
    return x;
end

real Doub(real b) begin
    real y = b * 2;
    print(y); // Deve imprimir: 6.28
    return y;
end

// Função para operadores lógicos
void logicalOperators() begin
    result1 = c and true;
    print(result1); // Deve imprimir: true

    result2 = c or false;
    print(result2); // Deve imprimir: true

    result3 = not c;
    print(result3); // Deve imprimir: false
end

// Função para estruturas de controle
void controlStructures(int a) begin
    if (a > 5) then
    begin
        real o = 3.4;
        return;
        print("a é maior que 5"); // Deve imprimir: a é maior que 5
    end
    else
    begin
        print("a não é maior que 5");
    end

    while (i < 5) do
    begin
        print(i);
        i = i + 1;
    end
    // Deve imprimir: 0 1 2 3 4
end

// Função para a função greet
void greet(string name) begin
    print("Hello, " + name + "!");
end

// Função para o return statement
int add(int x, int y)
begin
    return x + y;
end

// Função principal
void main() begin
    printVariables();
    logicalOperators();
    controlStructures(4);
    greet("Pedro");
    x = add(3, 4);
    print(x); // Deve imprimir: 7

    // Comentários
    // Este é um comentário de linha única

    /*
    Este é um comentário
    de múltiplas linhas
    */

    // Finalização do teste
    print("Teste concluído.");
end
