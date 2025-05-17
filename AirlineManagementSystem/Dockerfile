# Use Docker official image with Docker CLI and Docker daemon (dind)
FROM docker:20.10.23-dind

# Install bash, openjdk-17, maven
RUN apk add --no-cache \
    bash \
    openjdk17 \
    maven=3.9.6-r0

# Set environment variables for Java and Maven
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk \
    PATH="/usr/lib/jvm/java-17-openjdk/bin:${PATH}"

# Verify versions (optional)
RUN java -version && mvn -version && docker --version

# Workdir can be set as needed (optional)
WORKDIR /app

# Use bash as default shell
CMD ["bash"]
