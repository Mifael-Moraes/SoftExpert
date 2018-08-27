insert into acao (id, id_comprador, iniciar, name, valor, preco_compra, preco_venda) values (1,1, true, 'PETROBRAS', 18.48, 16.63, 20.32);
insert into acao (id, id_comprador, iniciar, name, valor, preco_compra, preco_venda) values (2,2, true, 'VALE EM', 45.67, 41.10, 50.24);
insert into acao (id, id_comprador, iniciar, name, valor, preco_compra, preco_venda) values (3,3, true, 'ITAU UNICLASS', 79.39, 71.45, 87.33);

insert into comprador (id, acoes, name, saldo, volume) values (1, 1,'Mifael' ,100000, 0);
insert into comprador (id, acoes, name, saldo, volume) values (2, 2,'Felipe' ,100000, 0);
insert into comprador (id, acoes, name, saldo, volume) values (3, 3,'Jocélli',100000, 0);

select * from log_negociacao;
Select * from acao;
Select * from comprador;