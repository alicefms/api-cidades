# api-cidades
Api constuida em Java para consultar cidades e estados brasileiros e países. Também é possivel calculara a distancia entre cidades em milhas e em metros.
A Api foi desenvolvida no InteliJ, e executada localmente na porta 8080, e os gets também foram testados no Postman. 
A construção foi guiada por Andre Luis Gomes (https://github.com/andrelugomes), em um bootcamp na DIO.
Os dados utilizados foram disponibilizados por Chinnon Santos (https://github.com/chinnonsantos/sql-paises-estados-cidades.git), e foi criado um Banco de dados no Docker.


para executar:
-Para criar o BD no Docker:

>docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres

-Para popular o BD com os dados de Chinnon:
entra na pasta do clone do "sql-paises-estados-cidades", na pasta PostreSQL:

>docker run -it --rm --net=host -v %cd%:/tmp postgres /bin/bash 
// o comando orginal era docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash , mas nao rodou na minha máquina, que é Windows.

muda para a pasta tmp, e la executa os psql para popular o BD com os dados dos paises, dos estados e dos municípios.

>psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
>psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
>psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

-Para instalar as dependencias para calcular a distancia:
Executa este comando para entrar no BD:

>psql -h localhost -U postgres_user_city cities

e instala essas dependências:

>CREATE EXTENSION cube; 
>CREATE EXTENSION earthdistance;

Depois de tudo pronto, as responses chegam no endereço: "https://http://localhost:8080 + path"

no path "/countries" , os países;
no path: "/states" , os estados brasileiros;
no path "/cities" , as cidades brasileiras;
no path "/distances/by-points?from=1&to=2" , pode-se calcular a distancia em milhas entre cidades com id 1 e 2 por exemplo.
no path "/distances/by-cube?from=1&to=2" , pode-se calcular a distancia em metros entre as cidades.

Os dados estão paginados.





