-- COZINHA
insert into kitchen (name, id) values ("Brasileira", 1);
insert into kitchen (name, id) values ("Japonesa", 2);

-- FORMA DE PAGAMENTO
insert into payment_method (description) values ("Pagamento via PIX");
insert into payment_method (description) values ("pagamento a vista");
insert into payment_method (description) values ("Pagamento com cartão de crédito");
insert into payment_method (description) values ("Pagamento com cartão de débito");

-- RESTAURANTES
insert into restaurant (name, shipping_fee, kitchen_id, payment_methods_id) values ("Lanche Feliz", 4.00, 1, 1);
insert into restaurant (name, shipping_fee, kitchen_id, payment_methods_id) values ("Carro Burguer", 3.00, 1, 2);
insert into restaurant (name, shipping_fee, kitchen_id, payment_methods_id) values ("Lamen 1000", 5.50, 2, 3);

-- PERMISSÕES
insert into permissions (name, description) values ("consultar produtos", "permite consultar todos os produtos do projeto.");
insert into permissions (name, description) values ("excluir produtos", "permite excluir todos os produtos do projeto.");

-- ESTADOS
insert into state (name) values ("Ceará");
insert into state (name) values ("São Paulo");
insert into state (name) values ("Rio de Janeiro");

-- CIDADES
insert into city (name, state_id) values ("pentecoste", 1);
insert into city (name, state_id) values ("Ubatuba", 2);
insert into city (name, state_id) values ("Paraty", 3);