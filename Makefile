HOME = /Users/vsevolodmolchanov
PROJECT = $(HOME)/Documents/Study/Coding/University/Parallel/lab1
H_DATA = $(HOME)/hdata

.PHONY: all start_hadoop make_dirs make_package copy_file start_project restart_project stop_hadoop delete_output clean stop_n_clean

all: start_hadoop make_dirs copy_file start_project

start_hadoop:
	@echo "\n\n*****************STARTING HADOOP*****************\n\n"
	hdfs namenode -format
	start-dfs.sh
	start-yarn.sh

make_dirs:
	@echo "\n\n*****************MAKING NECESSARY DIRS*****************\n\n"
	hadoop fs -mkdir /user
	hadoop fs -mkdir /user/vsevolodmolchanov

make_package:
	@echo "\n\n*****************MAKING THE PROJECT*****************\n\n"
	mvn -f $(PROJECT) package

copy_file:
	@echo "\n\n*****************COPYING THE FILE*****************\n\n"
	# hadoop fs -copyFromLocal $(PROJECT)/warandpeace1.txt
	hadoop fs -copyFromLocal $(PROJECT)/L_AIRPORT_ID.csv

start_project:
	@echo "\n\n*****************STARTING THE PROJECT*****************\n\n"
	export HADOOP_CLASSPATH=$(PROJECT)/target/hadoop-examples-1.0-SNAPSHOT.jar
	# hadoop WordCountApp warandpeace1.txt output
	hadoop WordCountApp L_AIRPORT_ID.csv output
	hadoop fs -copyToLocal output $(PROJECT)

restart_project: delete_output start_project

stop_hadoop:
	@echo "\n\n*****************STOPPING HADOOP*****************\n\n"
	stop-yarn.sh
	stop-dfs.sh

delete_output:
	@echo "\n\n*****************DELETING OUTPUT*****************\n\n"
	hadoop fs -rm -r -f output
	rm -rf $(PROJECT)/output

clean:
	@echo "\n\n*****************CLEANING HADOOP FILES*****************\n\n"
	rm -rf $(H_DATA)/namenode/current
	rm -rf $(H_DATA)/datanode/current
	rm -rf $(PROJECT)/output

stop_n_clean: stop_hadoop clean
