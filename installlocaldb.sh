echo "This will install PostgreSql + Create a user +password +database"
echo -n "Press [ENTER] to continue,...: "
read pause

sudo apt-get install postgresql
echo "Change listen_address"
echo "Change password_encryption"
echo -n "Press [ENTER] to continue,...: "
read pause
sudo vim /etc/postgresql/9.1/main/postgresql.conf

echo "input password for dbuser"
echo -n "Press [ENTER] to continue,...: "
read pause
sudo -u postgres createuser -D -E -l -R -S -e ss13-proj1

sudo -u postgres createdb -e ss13-proj1
sudo -u postgres psql -a -c "alter user \"ss13-proj1\" with encrypted password 'aiXeem3fahch7odo';"
sudo -u postgres psql -a -c "grant all privileges on database \"ss13-proj1\" to \"ss13-proj1\";"
