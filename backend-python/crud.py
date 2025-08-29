from sqlalchemy import create_engine, Column, Integer, String
from sqlalchemy.orm import sessionmaker, declarative_base

# Define database
engine = create_engine("sqlite:///database.db", echo=True)
Session = sessionmaker(bind=engine)
Base = declarative_base()

# Data model
class DataEntity(Base):
    __tablename__ = 'data_entity'

    id = Column(Integer, primary_key=True)
    name = Column(String, nullable=False)
    description = Column(String)

# Create table
Base.metadata.create_all(engine)

# CRUD Operations

def create_data(name, description):
    session = Session()
    data = DataEntity(name=name, description=description)
    session.add(data)
    session.commit()
    result = {
        "id": data.id,
        "name": data.name,
        "description": data.description
    }
    session.close()
    return result

def read_data(data_id):
    session = Session()
    data = session.query(DataEntity).get(data_id)
    session.close()
    if data:
        return {
            "id": data.id,
            "name": data.name,
            "description": data.description
        }
    return None

def update_data(data_id, name=None, description=None):
    session = Session()
    data = session.query(DataEntity).get(data_id)
    if data:
        if name is not None:
            data.name = name
        if description is not None:
            data.description = description
        session.commit()
        result = {
            "id": data.id,
            "name": data.name,
            "description": data.description
        }
        session.close()
        return result
    session.close()
    return None

def delete_data(data_id):
    session = Session()
    data = session.query(DataEntity).get(data_id)
    if data:
        session.delete(data)
        session.commit()
        session.close()
        return True
    session.close()
    return False
