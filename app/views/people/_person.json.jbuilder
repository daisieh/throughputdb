json.extract! person, :id, :creator, :target, :body, :created_at, :updated_at
json.url person_url(person, format: :json)
