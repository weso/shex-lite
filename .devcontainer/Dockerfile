# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.155.1/containers/java/.devcontainer/base.Dockerfile

# [Choice] Java version: 15
FROM ubuntu:18.04

# [Option] Install Gradle

# [Option] Install sbt
# RUN \
#   curl -L -o sbt-1.4.7.deb http://dl.bintray.com/sbt/debian/sbt-1.4.7.deb && \
#   dpkg -i sbt-1.4.7.deb && \
#   rm sbt-1.4.7.deb && \
#   apt-get update && \
#   apt-get install sbt && \
#   sbt sbtVersion

RUN apt-get update
RUN apt-get -qq -y install curl wget unzip zip
RUN apt-get install -y openjdk-11-jdk

RUN curl -s "https://get.sdkman.io" | bash
# RUN source "$HOME/.sdkman/bin/sdkman-init.sh"

RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && \
    yes | sdk install sbt && \
    yes | sdk install scala 2.13.1 && \
    rm -rf $HOME/.sdkman/archives/* && \
    rm -rf $HOME/.sdkman/tmp/*"

ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/
RUN export JAVA_HOME

#RUN sdk install java 15.0.1-amzn
#RUN sdk install sbt
#RUN sdk install scala 2.13.1

# [Optional] Uncomment this section to install additional OS packages.
# RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
#     && apt-get -y install --no-install-recommends <your-package-list-here>

# [Optional] Uncomment this line to install global node packages.
# RUN su vscode -c "source /usr/local/share/nvm/nvm.sh && npm install -g <your-package-here>" 2>&1