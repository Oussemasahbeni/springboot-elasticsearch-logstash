FROM docker.elastic.co/logstash/logstash:8.7.0

# Download the PostgreSQL JDBC driver and place it in the Logstash classpath
RUN curl -o /usr/share/logstash/logstash-core/lib/jars/postgresql-42.7.2.jar https://jdbc.postgresql.org/download/postgresql-42.7.2.jar

# Copy your Logstash config
COPY config/ /usr/share/logstash/config/

# Run Logstash with your config
CMD ["logstash", "-f", "/usr/share/logstash/config/logstash.conf"]
