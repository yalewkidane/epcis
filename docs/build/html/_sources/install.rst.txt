.. _istall:



Install
=========


Linux [Ubuntu]: 
------------------

Install JAVA 
*****************

To install java 8 from openjdk

.. code-block:: RST

	$ sudo apt-get install openjdk-8-jdk

Open /etc/profile

.. code-block:: RST

	$ vim /etc/profile

Add: 

.. code-block:: RST

	export JAVA_HOME=“/usr/lib/jvm/java-8-openjdk-amd64”
	export PATH=$JAVA_HOME/bin:$PATH

To apply the changes

.. code-block:: RST

	$ source /etc/profile

To check if it is properly setup

.. code-block:: RST

	$ $JAVA_HOME


Install Mongodb
********************

| For more information : https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/
| For other OS : https://docs.mongodb.com/manual/installation/#mongodb-community-edition-installation-tutorials

Import the public key used by the package management system

.. code-block:: RST

	wget -qO - https://www.mongodb.org/static/pgp/server-4.2.asc | sudo apt-key add -

Create a list file for MongoDB

.. code-block:: RST

	echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu xenial/mongodb-org/4.2 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-4.2.list

Reload local package database

.. code-block:: RST

	sudo apt-get update

Install the MongoDB packages

.. code-block:: RST

	sudo apt-get install -y mongodb-org

Start MongoDB

.. code-block:: RST

	sudo systemctl start mongod

Verify that MongoDB has started successfully

.. code-block:: RST

	sudo systemctl status mongod



Install tomcat 8.5
************************

For testing: 
^^^^^^^^^^^^^^^

Download apchae tomcat 8.5

.. code-block:: RST

	wget http://apache.mirror.cdnetworks.com/tomcat/tomcat-8/v8.5.55/bin/apache-tomcat-8.5.55.tar.gz

download epcis war file

.. code-block:: RST

	wget https://github.com/JaewookByun/epcis/raw/master/epcis.war

extract apache tomcat 

.. code-block:: RST

	tar -xzvf apache-tomcat-8.5.55.tar.gz

move epcis war file to apache webapp folder: 

.. code-block:: RST

	mv epcis.war apache-tomcat-8.5.55/webapps/

Start EPCIS 

.. code-block:: RST

	./apache-tomcat-8.5.55/bin/catalina.sh start


Open EPCIS Dashboard:

.. code-block:: RST

	open http://localhost:8080/epcis/


.. image:: ./images/epcis_dashboard.png

For Production: 
^^^^^^^^^^^^^^^^^^

Use the following link to install apache tomcat : https://www.digitalocean.com/community/tutorials/how-to-install-apache-tomcat-8-on-ubuntu-16-04

Window: 
------------

Install JAVA
********************

https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

Install Mongodb
********************

http://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/

Install tomcat 8.0
************************

https://tomcat.apache.org/tomcat-8.5-doc/setup.html

