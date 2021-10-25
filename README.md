# Desafio Java + Spring Framework + JPA

### Objetivos - Pendências

- Desafio 1 - Testes PresenteItem.
- Desafio 2 - Completo.
- Desafio 3 - Logica do dos 10 itens mais bem avaliados; Exibição no endpoint.


### REST API

As Requests que possuem id, são literalmente o id do item que será gerado ao criar. Basta inseri-lo
e realizar a consulta.


![image](https://user-images.githubusercontent.com/32139927/138619164-b89ee821-379c-4497-b579-61997635fe54.png)


De acordo com o CRUD Realizad no Desafio 1 para o package Presente seguem as requests no Padrão Rest
Para os testes.

- ListaPresentes

![image](https://user-images.githubusercontent.com/32139927/138619194-3c9fe40d-4f6f-42f0-b807-e3682b8fabce.png)

http://localhost:8080/presentes/listaPresentes

- PresenteById

![image](https://user-images.githubusercontent.com/32139927/138619217-688bd8b4-ebb3-4b7f-a1e5-15b645730813.png)

http://localhost:8080/presentes/presente/{id}

- DeletePresente

![image](https://user-images.githubusercontent.com/32139927/138619250-7c38ea4a-fdd4-413d-bb28-2b74f9f7a7d7.png)

http://localhost:8080/presentes/presente/deletePresente/{id}

- CriaPresente

![image](https://user-images.githubusercontent.com/32139927/138619299-b1fb792f-8d18-4c6d-9e4a-dab1beaa01a3.png)

http://localhost:8080/presentes/presente/criaPresente

O @RequestBody deve conter os seguintes parâmetros, exemplo:

```
{
    "nome": "Imã de geladeira Calendario 1 un - Doce Sonho",
    "preco": 0.01,
    "nota": [5]
}
```
- UpdatePresente

![image](https://user-images.githubusercontent.com/32139927/138619377-3766a05f-217d-4e5d-a85f-e403a8884c8a.png)

http://localhost:8080/presentes/presente/atualizaPresente/{id}

O @RequestBody deve conter os seguintes parâmetros, exemplo:

```
{
    "nome": "Imã de geladeira Calendario 2 un - Doce Sonho",
    "preco": 0.05,
    "nota": [
        
    ]
}
```

### Conclusão

O desafio foi sensacional, foi um contato muito forte com todos esses conceitos que até então 
são novidade para mim. Aprendi demais com o tudo e mesmo sem conseguir completar todos e independente
do resultado já ganhei muito com tudo isso. A partir desse momento eu sei a onde eu preciso ir para corrigir
e aperfeiçoar meus conhecimentos na framework. Gostaria de agradecer pela oportunidade do desafio, entrevistas
e o contato. Obrigado também por acreditarem no meu potencial, caso seja escolhido darei o meu melhor para
atender as demandas e absorver todo o conteúdo e aprendizado para atingir os resultados e crescer
junto com a empresa. 


