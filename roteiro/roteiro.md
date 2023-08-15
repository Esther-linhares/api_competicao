# atleta:

    cpf
    nome
    idade
    genero
    clube-id 
    categoria-id
    provas-atleta (se der tempo depois do tempo)

# clube:
    id
    nome
    estado (RS)
    data da fundação

# categoria:
    id
    nome
    faixa etaria
    gênero permitido (masculino, feminino, misto)

### Cadastrar clube
- não pode ter dois clubes com o mesmo nome
- um clube pode ter mais de um atleta mas um atleta só pode ter um clube
- 
### cadastrar atleta
- não pode ter o mesmo cpf

(se der tempo)
# prova :
    id
    nome
    categoria_id

# provas:
    id
    atleta-id
    prova-id 
    

### provas
- listar atletas que participam da prova 
- um atleta pode estar em amis de uma prova
- quando for adicionar atleta verificar se categoria é a mesma


### Clube - Atleta: Relacionamento 1:N (um clube possui vários atletas, um atleta pertence a apenas um clube)
### Clube - Categoria: Relacionamento N:M (um clube pode participar de várias categorias, e uma categoria pode ter vários clubes participantes)
### Atleta - Categoria: Relacionamento N:M (um atleta pode participar de várias categorias, e uma categoria pode ter vários atletas participantes)
### Prova - Atleta: Relacionamento N:M (uma prova pode ter vários atletas participantes e um atleta pode participar de várias provas)