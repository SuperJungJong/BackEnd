help:
	@echo 명령어 목록
	@echo \'docker-build-apt\': 아파트 서버 도커 빌드
	@echo \'docker-build-mono\': 단다가구 서버 도커 빌드
	@echo \'docker-build-map\': 지도 서버 도커 빌드
	@echo \'docker-build-all\': 모든 서버 도커 빌드

docker-build-apt:
	@echo 아파트 서버 빌드
	@docker build --platform linux/amd64 -t rnrmf/homes-apt ./homes-apt
	@docker push rnrmf/homes-apt

docker-build-mono:
	@echo 단다가구 서버 빌드
	@docker build --platform linux/amd64 -t rnrmf/homes-mono ./homes-mono
	@docker push rnrmf/homes-mono

docker-build-map:
	@echo 지도 서버 빌드
	@docker build --platform linux/amd64 -t rnrmf/homes-map ./homes-map
	@docker push rnrmf/homes-map

docker-build-user:
	@echo 유저 서버 빌드
	@docker build --platform linux/amd64 -t rnrmf/homes-user ./homes-user
	@docker push rnrmf/homes-user

docker-build-all:
	@echo 모든 서버 빌드 시작
	@make docker-build-apt
	@make docker-build-monod
	@make docker-build-map
	@make docker-build-user
	@docker push rnrmf/homes-apt
	@docker push rnrmf/homes-mono
	@docker push rnrmf/homes-map
	@docker push rnrmf/homes-user
