# SoftExpert
Diretório com o teste de proficiência técnica

# Instalação
Para Instalar deve-se adicionar todos os projetos importando como Existing Maven Projects.

Após isso criar no PostgreSQL um DataBase chamado "bolcavalores".

Rodar Acoes, Mercado, Comprador e AutoBooking a primeira vez para criar as tabelas.

Adicionar no Banco (Script SQL) ou via Posmans utilizando o serviço Rest para cadastro (PostMan ou SoapUI).

Para Startar a operação abrir em um browser "http://localhost:9898/autobooking".

Após isso pode-se acompanhar as negociações atravez do console do Spring/Netbens/InteliJ.

#Sobre as estruturas escolhidas

JPA para persistencia utilizando o framework Crud.

RestTamplate como cliente entre os webServices Rest para fazer as consultas no WebServices

Não utilizei JMS pois como o preço variava de 5 em 5 segundos preferi optar por uma forma sincrona.
