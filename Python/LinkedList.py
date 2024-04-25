class No:
    def __init(self, valor,comeco,fim):
        self.valor = valor
        self.comeco = None
        self.fim = None

class ListaEncadeada:

    def __init__(self):
        self.comeco = None
        self.fim = None
        tamanho = 0

    def inserirPrimeiro(self, valor):
        novoNo = No(valor)
        if tamanho == 0:
            self.comeco = novoNo
            self.fim = novoNo
        else:
            novoNo.proximo = self.comeco
            self.comeco = novoNo
        tamanho += 1

    def adicionar(self, valor):
        novoNo = No(valor)
        if tamanho == 0:
            self.comeco = novoNo
            self.fim = novoNo


