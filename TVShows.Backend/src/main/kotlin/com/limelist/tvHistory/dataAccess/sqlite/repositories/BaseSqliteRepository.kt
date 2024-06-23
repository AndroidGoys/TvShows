package com.limelist.tvHistory.dataAccess.sqlite.repositories
import java.sql.Connection

abstract class BaseSqliteRepository(
    protected val connection: Connection
) {

    init {
        initialize(connection)
    }

    companion object {
        fun initialize(connection: Connection) {
            val statement = connection.createStatement();

            statement.execute("""
                CREATE TABLE IF NOT EXISTS channels (
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(50) NOT NULL,
                    description TEXT NOT NULL
                );
            """)

            statement.execute("""
                CREATE TABLE IF NOT EXISTS shows (
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(50) NOT NULL,
                    description TEXT NOT NULL,  
                    preview_url TEXT NOT NULL
                );
            """)

            statement.execute("""
                CREATE TABLE IF NOT EXISTS show_reviews (
                    id SERIAL PRIMARY KEY,
                    show_id INTEGER REFERENCES tv_shows,
                    date REAL,  
                    comment TEXT,
                    assessment INTEGER
                );
            """)

            statement.execute("""
                CREATE TABLE IF NOT EXISTS channel_reviews (
                    id SERIAL PRIMARY KEY,
                    channel_id INTEGER REFERENCES shows,
                    date REAL,  
                    comment TEXT,
                    assessment INTEGER
                );
            """)

            statement.execute("""
                CREATE TABLE IF NOT EXISTS show_dates (
                    id SERIAL PRIMARY KEY,
                    show_id INTEGER REFERENCES shows,
                    channel_id INTEGER REFERENCES channels,
                    time_start REAL,
                    time_stop REAL
                );
            """)


            statement.execute("""
                CREATE TABLE IF NOT EXISTS channel_view_urls (
                    id SERIAL PRIMARY KEY,
                    channel_id INTEGER REFERENCES channels,
                    url TEXT NOT NULL
                );
            """)


            statement.close()
        }
    }
}
