from flask import Flask, request, jsonify
import crud

app = Flask(__name__)

@app.route("/")
def index():
    return jsonify({"message": "AI Data Governance API is running"})

@app.route("/data", methods=["POST"])
def create():
    data = request.json
    new_data = crud.create_data(data["name"], data.get("description"))
    return jsonify(new_data)

@app.route("/data/<int:data_id>", methods=["GET"])
def read(data_id):
    data = crud.read_data(data_id)
    if data:
        return jsonify(data)
    return jsonify({"error": "Data not found"}), 404

@app.route("/data/<int:data_id>", methods=["PUT"])
def update(data_id):
    data = request.json
    updated_data = crud.update_data(data_id, data.get("name"), data.get("description"))
    if updated_data:
        return jsonify(updated_data)
    return jsonify({"error": "Data not found"}), 404

@app.route("/data/<int:data_id>", methods=["DELETE"])
def delete(data_id):
    deleted = crud.delete_data(data_id)
    if deleted:
        return jsonify({"message": "Deleted successfully"})
    return jsonify({"error": "Data not found"}), 404

if __name__ == "__main__":
    app.run(debug=True, port=5000)
