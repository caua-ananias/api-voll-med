alter table medicos add column ativo tinyint;
update medicos set ativo = 0;
alter table medicos modify ativo tinyint not null;