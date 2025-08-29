from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

# SQLite for local development
DATABASE_URL = "sqlite:///../data/database.db"

engine = create_engine(DATABASE_URL, echo=True)
SessionLocal = sessionmaker(bind=engine)
