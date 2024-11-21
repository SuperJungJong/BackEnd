help:
	@echo 명령어 목록
	@echo \'docker-run-apt\': 아파트 서버 도커 ㅣㄹ행
	@echo \'docker-run-mono\': 단다가구 서버 도커 싫애
	@echo \'docker-run-user\': 지도 서버 도커 싫애
	@echo \'docker-run-map\': 지도 서버 도커 싫애
	@echo \'docker-run-all\': 모든 서버 도커 싫애

docker-run-apt:
	@echo 아파트 서버 싫애
	@docker pull rnrmf/homes-apt
	@docker stop homes-apt
	@docker rm homes-apt
	@docker run -d -p 8081:8081 --name homes-apt --network homes-db_apt-network rnrmf/homes-apt

docker-run-mono:
	@echo 단다가구 서버 싫애
	@docker pull rnrmf/homes-mono
	@docker stop homes-mono
	@docker rm homes-mono
	# @docker run -d -p 8082:8082 --name homes-mono --network homes-db_mono-network rnrmf/homes-mono
	@docker run -d -p 8082:8082 --name homes-mono rnrmf/homes-mono

docker-run-user:
	@echo 유저 서버 싫애
	@docker pull rnrmf/homes-user
	@docker stop homes-user
	@docker rm homes-user
	@docker run -d -p 8083:8083 --name homes-user --network homes-db_user-network rnrmf/homes-user

docker-run-map:
	@echo 지도 서버 싫애
	@docker pull rnrmf/homes-map
	@docker stop homes-map
	@docker rm homes-map
	@docker run -d -p 8084:8084 --name homes-map --network homes-db_map-network rnrmf/homes-map


docker-run-all:
	@echo 모든 서버 빌드 시작
	@make docker-run-apt
	@make docker-run-mono
	@make docker-run-user
	@make docker-run-map

docker-down-all:
	@docker stop $(@docker ps -a -q)

docker-down-rm-all:
	@make docker-down-all
	@docker image rm -f $(@docker image ls -q)