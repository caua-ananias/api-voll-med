alter table medicos add column ativo tinyint;
update medicos set ativo = 1;
alter table medicos modify ativo tinyint not null;