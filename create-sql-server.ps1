$RG = "rg-movtodimdim"
$LOCATION = "mexicocentral"
$SERVER_NAME = "sqlserver-rm559597"
$USERNAME = "admsql"
$PASSWORD = "Fiap@2tdsvms"
$DBNAME = "dimdimdb"

az group create --name $RG --location $LOCATION
az sql server create -l $LOCATION -g $RG -n $SERVER_NAME -u $USERNAME -p $PASSWORD --enable-public-network true
az sql db create -g $RG -s $SERVER_NAME -n $DBNAME --service-objective Basic --backup-storage-redundancy Local --zone-redundant false
az sql server firewall-rule create -g $RG -s $SERVER_NAME -n AllowAll --start-ip-address 0.0.0.0 --end-ip-address 255.255.255.255

# Cria os objetos de Banco
# Certifique-se de ter o sqlcmd instalado em seu ambiente
Invoke-Sqlcmd -ServerInstance "$SERVER_NAME.database.windows.net" `
              -Database "$DBNAME" `
              -Username "$USERNAME" `
              -Password "$PASSWORD" `
              -Query @"
CREATE TABLE tb_jogo (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    plataforma VARCHAR(50),
    preco DECIMAL(10,2)
);

CREATE TABLE tb_livro (
    id INT IDENTITY(1,1) PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100),
    editora VARCHAR(100),
    preco DECIMAL(10,2)
);
"@
