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
	@echo 아파트 끝~~

docker-build-mono:
	@echo 단다가구 서버 빌드
	@docker build --platform linux/amd64 -t rnrmf/homes-mono ./homes-mono
	@docker push rnrmf/homes-mono
	@echo 단다가구 끝~~

docker-build-map:
	@echo 지도 서버 빌드
	@docker build --platform linux/amd64 -t rnrmf/homes-map ./homes-map
	@docker push rnrmf/homes-map
	@echo 지도  끝~~

docker-build-user:
	@echo 유저 서버 빌드
	@docker build --platform linux/amd64 -t rnrmf/homes-user ./homes-user
	@docker push rnrmf/homes-user
	@echo 유저 끝~~

docker-build-ai:
	@echo ai 서버 빌드
	@docker build --platform linux/amd64 -t rnrmf/homes-ai ./homes-ai
	@docker push rnrmf/homes-ai
	@echo ai 끝~~

docker-build-all:
	@./gradlew bootRun
	@echo 모든 서버 빌드 시작
	@make docker-build-apt
	@make docker-build-mono
	@make docker-build-map
	@make docker-build-userss
	@echo docker-build-ai
	@echo 모든 거 끝~~
